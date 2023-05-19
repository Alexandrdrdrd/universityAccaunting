package com.sasha.task.UniversityAccountingSystem.services.implementations;

import com.sasha.task.UniversityAccountingSystem.entity.Lector;
import com.sasha.task.UniversityAccountingSystem.repository.LectorRepository;
import com.sasha.task.UniversityAccountingSystem.services.interfaces.LectorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectorServiceImpl implements LectorServiceInterface {
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }


    /**
     * Performs a global search for lectors based on the provided template.
     * The search is case-insensitive and looks for lectors whose names contain the template.
     *
     * @param template the search template
     * @return a string representation of the matching lector names separated by commas,
     * or "No matching results" if no lectors match the search
     */
    public String globalSearch(String template) {
        List<Lector> lectors = lectorRepository.findByNameContaining(template);
        if (!lectors.isEmpty()) {
            List<String> names = lectors.stream()
                    .map(Lector::getName)
                    .collect(Collectors.toList());
            return String.join(", ", names);
        } else {
            return "No matching results";
        }
    }
}
