package net.proselyte.streamapi;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;
import net.proselyte.streamapi.util.OldApproachUtil;
import net.proselyte.streamapi.util.StreamAPIUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static net.proselyte.streamapi.util.StreamAPIUtil.*;


public class StreamAPIDemo {
    public static void main(String[] args) {
        //List<Specialist> specialists = OldApproachUtil.getSpecialists();
        List<Specialist> specialists = StreamAPIUtil.getSpecialists();

        // Filter
//        List<Specialist> engineers = OldApproachUtil.filterBySpecialty(specialists, Specialty.ENGINEER);
        List<Specialist> engineers = StreamAPIUtil.filterBySpecialty(specialists, Specialty.ENGINEER);
        StreamAPIUtil.printSpecialists(engineers);

        // Sorting
        List<Specialist> sortedSpecialistsAsc = StreamAPIUtil.sortSpecialistsByNameAsc(specialists);
        List<Specialist> sortedSpecialistsDesc = StreamAPIUtil.sortSpecialistsByNameDesc(specialists);
        StreamAPIUtil.printSpecialists(sortedSpecialistsAsc);
        StreamAPIUtil.printSpecialists(sortedSpecialistsDesc);

        // Max salary
        Specialist withMaxSalary = StreamAPIUtil.findWithMaxSalary(specialists);
        System.out.println(withMaxSalary);
        // Min salary
        Specialist withMinSalary = StreamAPIUtil.findWithMinSalary(specialists);
        System.out.println(withMinSalary);

        // Grouping
        Map<Specialty, List<Specialist>> groupedBySpecialty = StreamAPIUtil.groupBySpecialty(specialists);
        System.out.println(groupedBySpecialty);

        // All engineers
//        boolean allEngineers = OldApproachUtil.matchAllEngineers(specialists);
        boolean allEngineers = StreamAPIUtil.matchAllEngineers(specialists);
        System.out.println(allEngineers);

        // Any engineers
//        boolean anyEngineer = OldApproachUtil.matchAnyEnginner(specialists);
        boolean anyEngineer = StreamAPIUtil.matchAnyEngineer(specialists);
        System.out.println(anyEngineer);

        // All salary more then
        //boolean allSalaryMoreThen1000 = OldApproachUtil.matchAllSalaryMoreThen(specialists, new BigDecimal(10000));
        boolean allSalaryMoreThen1000 = StreamAPIUtil.matchAllSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(allSalaryMoreThen1000);

        // No one with salary more then
//        boolean noOneWithSalaryMoreThen10000 = OldApproachUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        boolean noOneWithSalaryMoreThen10000 = StreamAPIUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(noOneWithSalaryMoreThen10000);
    }
}