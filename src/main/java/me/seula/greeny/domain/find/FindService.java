package me.seula.greeny.domain.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
    private final FindRepository findRepository;

    @Autowired
    public FindService(FindRepository findRepository) {
        this.findRepository = findRepository;
    }

    public List<Long> findDistinctProductIdsByUsernameNot(String username) {
        return findRepository.findDistinctProductIdsByUsernameNot(username);
    }
}
