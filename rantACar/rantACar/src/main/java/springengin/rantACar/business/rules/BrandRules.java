package springengin.rantACar.business.rules;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import springengin.rantACar.core.utilities.exceptions.BusinessException;
import springengin.rantACar.dataAccess.abstaracts.Brandrepository;

@AllArgsConstructor
@Service
public class BrandRules {
    private Brandrepository brandrepository;

    public void checkIfBrandNameExists(String name) {
        if (this.brandrepository.existsByName(name)) {
            throw new BusinessException("Brand already exists");
        }
    }
}