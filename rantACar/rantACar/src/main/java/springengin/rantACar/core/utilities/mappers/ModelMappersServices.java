package springengin.rantACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMappersServices {
ModelMapper forResponse();
ModelMapper forRequest();

}
