package springengin.rantACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service // Spring'in bu sınıfı yönetebilmesi için şarttır
public class ModelMapperManager implements ModelMappersServices {

    private final ModelMapper modelMapper;

    // Dependency Injection ile ModelMapper'ı içeri alıyoruz
    public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }
}