package com.tobeto.bootcampProject.core.utilities.mapping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest(){
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
