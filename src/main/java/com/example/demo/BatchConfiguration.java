package com.example.demo;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ImportRuntimeHints(NativeCompileHints.class)
public class BatchConfiguration {

    @Bean
    public FlatFileItemReader<Customer> reader() {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("customerReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names(new String[] { "firstName", "lastName","birthday","gender","married" })
                .fieldSetMapper(new CustomerMapper())
                .build();
    }

    @Autowired
    private EntityManagerFactory emf;

    @Bean
    public JpaItemWriter<Customer> writer() {
        JpaItemWriter<Customer> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(emf);
        return writer;
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
            JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
            PlatformTransactionManager transactionManager, JpaItemWriter<Customer> writer,
            CustomerItemProcessor processor, FlatFileItemReader<Customer> reader) {
        return new StepBuilder("step1", jobRepository)
                .<Customer, Customer>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
