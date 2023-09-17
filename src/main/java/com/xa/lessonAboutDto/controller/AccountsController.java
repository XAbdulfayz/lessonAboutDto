package com.xa.lessonAboutDto.controller;

import com.xa.lessonAboutDto.dto.accounts.AccountCreateDto;
import com.xa.lessonAboutDto.dto.accounts.AccountGetDto;
import com.xa.lessonAboutDto.dto.accounts.AccountUpdateDto;
import com.xa.lessonAboutDto.etity.Accounts;
import com.xa.lessonAboutDto.service.AccountsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account/")
public class AccountsController {

    private final AccountsService service;

    public AccountsController(AccountsService service) {
        this.service = service;
    }

    @PutMapping("update/")
    public Accounts put(@RequestBody AccountUpdateDto AccountUpdateDto) {
        return service.update(AccountUpdateDto);
    }

    @GetMapping("get/")
    public Accounts get(@RequestBody AccountGetDto AccountGetDto) {
        return service.getById(AccountGetDto.getId());
    }

    @PostMapping("create/")
    public Accounts create(@RequestBody AccountCreateDto AccountCreateDto) {
        return service.create(AccountCreateDto);
    }

}
