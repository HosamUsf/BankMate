package com.dev.BankMate.notices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoticeService {
    private NoticeRepository repository;

    public List<Notice> getAllNotices(){
        return repository.findAllActiveNotices();
    }
}
