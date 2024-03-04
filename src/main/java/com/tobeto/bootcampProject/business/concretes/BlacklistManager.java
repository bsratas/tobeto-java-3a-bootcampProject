package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BlacklistService;
import com.tobeto.bootcampProject.business.requests.create.blacklist.CreateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.blacklist.UpdateBlacklistRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcampProject.business.responses.create.blacklist.CreateBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetAllBlacklistResponse;
import com.tobeto.bootcampProject.business.responses.get.blacklist.GetBlacklistByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.application.UpdateApplicationResponse;
import com.tobeto.bootcampProject.business.responses.update.blacklist.UpdateBlacklistResponse;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BlacklistRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.Application;
import com.tobeto.bootcampProject.entities.Blacklist;
import com.tobeto.bootcampProject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {

    private BlacklistRepository blacklistRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateBlacklistResponse> createBlacklist(CreateBlacklistRequest request) {
        Blacklist blacklist = mapperService.forRequest().map(request, Blacklist.class);
        blacklist.setCreatedDate(LocalDateTime.now());
        blacklistRepository.save(blacklist);

        CreateBlacklistResponse response = mapperService.forResponse().map(blacklist, CreateBlacklistResponse.class);

        return new SuccessDataResult<CreateBlacklistResponse>(response, "Blacklist Created");
    }

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAllBlacklist() {
        List <Blacklist> blacklists = blacklistRepository.findAll();
        List <GetAllBlacklistResponse> response = blacklists.stream().map(blacklist -> mapperService.
                forResponse().map(blacklist, GetAllBlacklistResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBlacklistResponse>>(response, "All Blacklists Listed");

    }

    @Override
    public DataResult<GetBlacklistByIdResponse> getBlacklistById(int id) {
        Blacklist blacklist = blacklistRepository.findById(id);
        GetBlacklistByIdResponse response = mapperService.forResponse().map(blacklist, GetBlacklistByIdResponse.class);
        return new SuccessDataResult<GetBlacklistByIdResponse>(response, "The Blacklist Listed");
    }

    @Override
    public DataResult<UpdateBlacklistResponse> updateBlacklist(UpdateBlacklistRequest request) {
        Blacklist blacklist = mapperService.forRequest().map(request, Blacklist.class);
        blacklist.setUpdatedDate(LocalDateTime.now());
        blacklistRepository.save(blacklist);

        UpdateBlacklistResponse response = mapperService.forResponse().map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult<UpdateBlacklistResponse>(response, "Blacklist Updated");
    }

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Blacklist> blacklists = blacklistRepository.findAll(pageable);
        List <GetAllBlacklistResponse> response = blacklists.stream().map(blacklist -> mapperService.forResponse().map(blacklist, GetAllBlacklistResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBlacklistResponse>>(response, "All Blacklists Sorted");
    }

    @Override
    public Result deleteBlacklist(int id) {
        blacklistRepository.deleteById(id);
        return new SuccessResult("Blacklist Deleted!");
    }


}
