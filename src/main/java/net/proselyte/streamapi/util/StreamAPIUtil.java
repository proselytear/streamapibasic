package net.proselyte.streamapi.util;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIUtil {
    // Получение начального списка специалистов
    public static List<Specialist> getSpecialists() {
        return List.of(
                new Specialist("Ivan Ivanov", new BigDecimal(5000), Specialty.ENGINEER),
                new Specialist("Alexander Alexandrov", new BigDecimal(4000), Specialty.ENGINEER),
                new Specialist("Sergey Sergeev", new BigDecimal(3000), Specialty.DEVOPS),
                new Specialist("Fedor Fedorov", new BigDecimal(2000), Specialty.DEVOPS),
                new Specialist("Kirill Kirillov", new BigDecimal(10000), Specialty.MANAGER),
                new Specialist("Petr Petrov", new BigDecimal(10000), Specialty.MANAGER)
        );
    }

    // Поиск по специальности
    public static List<Specialist> filterBySpecialty(List<Specialist> specialists, Specialty specialty) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpecialty().equals(specialty))
                .collect(Collectors.toList());
    }

    // Сортировка по имени по возрастанию
    public static List<Specialist> sortSpecialistsByNameAsc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName))
                .collect(Collectors.toList());
    }

    // Сортировка по имени по убыванию
    public static List<Specialist> sortSpecialistsByNameDesc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName).reversed())
                .collect(Collectors.toList());
    }

    // Проверка совпадений все инженеры
    public static boolean matchAllEngineers(List<Specialist> specialists) {
        return specialists.stream().allMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
    }

    // Проверка совпадений - есть ли инженеры
    public static boolean matchAnyEngineer(List<Specialist> specialists) {
        return specialists.stream().anyMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
    }

    // Проверка совпадений - все ли имеют ЗП выше указанной
    public static boolean matchAllSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream().allMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Проверка совпадений - никто не имеет ЗП выше указанной
    public static boolean matchNoneSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream().noneMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Вывод в консоль
    public static void printSpecialists(List<Specialist> specialists) {
        specialists.forEach(System.out::println);
    }

    // Поиск специалиста с максимальной ЗП
    public static Specialist findWithMaxSalary(List<Specialist> specialists) {
        return specialists.stream().max(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }

    // Поиск специалиста с минимальной ЗП
    public static Specialist findWithMinSalary(List<Specialist> specialists) {
        return specialists.stream().min(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }

    // Группировка по специалистов специальности
    public static Map<Specialty, List<Specialist>> groupBySpecialty(List<Specialist> specialists) {
        return specialists.stream().collect(Collectors.groupingBy(Specialist::getSpecialty));
    }
}
