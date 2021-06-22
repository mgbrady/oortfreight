package com.mbrady.oortfreight;

import com.mbrady.oortfreight.dao.IPlayerRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppCommandRunner implements CommandLineRunner {
    IPlayerRepo playerRepo;

    public void run(String... args) {
    }
}
