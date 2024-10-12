//package com.example.profiles.generate_data;
//
//import com.example.profiles.entity.Account;
//import com.example.profiles.enums.FlagEnum;
//import com.example.profiles.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.profiles")
//public class DataGenerator implements CommandLineRunner {
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        Account account = Account.builder()
//                .citizenCard("040203027904")
//                .fullName("DANG VAN SY")
//                .birthDate(LocalDate.parse("04/01/2003", dateTimeFormatter))
//                .email("sydv.work@gmail.com")
//                .phoneNumber("0369569225")
//                .adress("Nghe An")
//                .flag(FlagEnum.NOACTIVE.ordinal())
//                .build();
//        System.out.println(account);
//        accountRepository.save(account);
//    }
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(DataGenerator.class);
//        context.close();
//    }
//}
