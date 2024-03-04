package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BootcampService;
import com.tobeto.bootcampProject.business.requests.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampProject.business.requests.update.bootcamp.UpdateBootcampRequest;
import com.tobeto.bootcampProject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.tobeto.bootcampProject.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcamp.GetAllBootcampsResponse;
import com.tobeto.bootcampProject.business.responses.get.bootcamp.GetBootcampByIdResponse;
import com.tobeto.bootcampProject.business.responses.update.bootcamp.UpdateBootcampResponse;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.tobeto.bootcampProject.dataAccess.abstracts.BootcampStateRepository;
import com.tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import com.tobeto.bootcampProject.entities.Applicant;
import com.tobeto.bootcampProject.entities.Bootcamp;
import com.tobeto.bootcampProject.entities.BootcampState;
import com.tobeto.bootcampProject.entities.Instructor;
import jakarta.persistence.EntityNotFoundException;
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
public class BootcampManager implements BootcampService {

    private BootcampRepository bootcampRepository;
    private ModelMapperService mapperService;
    private BootcampStateRepository bootcampStateRepository;
    private InstructorRepository instructorRepository;
    @Override
    public DataResult<CreateBootcampResponse> createBootcamp(CreateBootcampRequest request) {
        Bootcamp bootcamp = mapperService.forRequest().map(request, Bootcamp.class);
        bootcamp.setCreatedDate(LocalDateTime.now());

        bootcampRepository.save(bootcamp);

        CreateBootcampResponse response = mapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult<CreateBootcampResponse>(response, "Bootcamp Created");
    }

    @Override
    public DataResult<GetAllBootcampsResponse> getAllBootcamps() {

        List <Bootcamp> bootcamps = bootcampRepository.findAll();

        List<GetAllBootcampsResponse> response = bootcamps.stream().map(bootcamp -> mapperService.
                forResponse().map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampsResponse>>(response, "All Bootcamps Listed");
    }

    @Override
    public DataResult<GetBootcampByIdResponse> getbootcamp(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        GetBootcampByIdResponse response = mapperService.forResponse().map(bootcamp, GetBootcampByIdResponse.class);
        return new SuccessDataResult<GetBootcampByIdResponse>(response, "Bootcamp Listed");
    }

    @Override
    public DataResult<UpdateBootcampResponse> updateBootcamp(UpdateBootcampRequest request) {
        Bootcamp bootcamp = mapperService.forRequest().map(request, Bootcamp.class);
        Bootcamp updatedBootcamp = bootcampRepository.save(bootcamp);

        UpdateBootcampResponse response = mapperService.forResponse().map(updatedBootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult<UpdateBootcampResponse>(response, "Bootcamp Updated");

    }

    @Override
    public DataResult<List<GetAllBootcampsResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Bootcamp> bootcamps = bootcampRepository.findAll(pageable);
        List <GetAllBootcampsResponse> response = bootcamps.stream().map(bootcamp -> mapperService.forResponse().map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampsResponse>>(response, "All Bootcamps Sorted");

    }

    @Override
    public Result deleteBootcamp(int id) {
        bootcampRepository.deleteById(id);
        return new SuccessResult("Bootcamp Deleted");
    }
}

