package springengin.rantACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllModelresponse {
private int id;
private String name;

private String brandName;

}
