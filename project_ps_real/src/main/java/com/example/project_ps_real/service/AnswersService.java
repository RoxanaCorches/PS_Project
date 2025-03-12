package com.example.project_ps_real.service;

import com.example.project_ps_real.entity.Answers;
import com.example.project_ps_real.entity.Post;
import com.example.project_ps_real.repository.AnswersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AnswersService {
    public AnswersRepository answersRepository;

    public AnswersService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public List<Answers> getAllAnswers() {
        return (List<Answers>) this.answersRepository.findAll();
    }

    public Answers getAnswersId(Long id) {
        Optional<Answers> answer = this.answersRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            return null;
        }
    }

    public Answers addAnswer(Answers answer) {
        return this.answersRepository.save(answer);
    }

    public Answers updateAnswer(Answers answer) {
        Optional<Answers> isAnswer=this.answersRepository.findById(answer.getAnswerId());
        if (isAnswer.isPresent()) {
             System.out.println("Post with id:"+answer.getAnswerId());
            return this.answersRepository.save(answer);
        }
        else {
            System.out.println("Post is not found");
            return null;
        }
    }

    public String deleteAnswer(Long id) {
        Optional<Answers> isAnswer=this.answersRepository.findById(id);
        if (isAnswer.isPresent()) {
            this.answersRepository.deleteById(id);
            return "Entry successfully deleted!";
        }
        else {
            return "Failed to delete user with id " + id;
        }
    }
}

