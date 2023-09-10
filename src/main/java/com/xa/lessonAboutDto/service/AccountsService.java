package com.xa.lessonAboutDto.service;

import com.xa.lessonAboutDto.dto.accounts.AccountCreateDto;
import com.xa.lessonAboutDto.dto.accounts.AccountGetDto;
import com.xa.lessonAboutDto.dto.accounts.AccountUpdateDto;
import com.xa.lessonAboutDto.etity.Accounts;
import com.xa.lessonAboutDto.repository.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountsService {

    private final AccountsRepository repository;

    public AccountsService(AccountsRepository repository) {
        this.repository = repository;
    }

    public AccountGetDto create(AccountCreateDto dto) {
        Accounts account = new Accounts();
        account.setName(dto.getName());
        account.setPassword(dto.getPassword());
        account.setPhoneNumber(dto.getPhoneNumber());

        Accounts result = repository.save(account);

         return new AccountGetDto(
                result.getId(),
                result.getName(),
                result.getPhoneNumber(),
                result.getPhoto()
                );
    }

    public AccountGetDto update(AccountUpdateDto dto){

        Optional<Accounts> byId = repository.findById(dto.getId());

        Accounts account = byId.get();

        account.setName(dto.getName());
        account.setPhoneNumber(dto.getPhoneNumber());
        account.setPassword(dto.getPassword());
        account.setPhoto(dto.getPhoto());

        Accounts result = repository.save(account);

        return new AccountGetDto(
                result.getId(),
                result.getName(),
                result.getPhoneNumber(),
                result.getPhoto()
        );
    }

    public AccountGetDto getById(Long id) {
        Optional<Accounts> result = repository.findById(id);
        Accounts account = result.get();
        return new AccountGetDto(
                account.getId(),
                account.getName(),
                account.getPhoneNumber(),
                account.getPhoto()
        );
    }

}
