package com.example.lms_prayekt.entity.sciences.repozitary;

import com.example.lms_prayekt.entity.sciences.entity.Sciences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SciencesRepazitory extends JpaRepository<Sciences, UUID> {
}
