package cc.tonny.optaplanner.exercise.springbootcloudbalance;

import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudBalance;
import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudComputer;
import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudProcess;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Override
    public void run(String...args) throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/data/computer-value/computers-2.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(is));
        List<CloudComputer> computers = new ArrayList<>(2);
        for (CSVRecord record : records) {
            computers.add(new CloudComputer(Long.parseLong(record.get("id")),
                    Integer.parseInt(record.get("cpu")),
                    Integer.parseInt(record.get("memory")),
                    Integer.parseInt(record.get("network")),
                    Integer.parseInt(record.get("cost"))));
        }

        is = this.getClass().getResourceAsStream("/data/process-value/processes-6.csv");
        records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(is));
        List<CloudProcess> processes = new ArrayList<>(6);
        for (CSVRecord record : records) {
            processes.add(new CloudProcess(Long.parseLong(record.get("id")),
                    Integer.parseInt(record.get("cpu")),
                    Integer.parseInt(record.get("memory")),
                    Integer.parseInt(record.get("network"))));
        }

        is = this.getClass().getResourceAsStream("/solution/solution.xml");
        SolverFactory<CloudBalance> solutionFactory = SolverFactory.createFromXmlInputStream(is);
        Solver<CloudBalance> solver = solutionFactory.buildSolver();
        CloudBalance solution = solver.solve(new CloudBalance(0L, computers, processes));

        System.out.println(solver.explainBestScore());
        solution.getCloudProcesses().forEach(System.out::println);

    }
}
