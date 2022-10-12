package website.bfmatching.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTeamDto {

    private String teamName;

    private Integer maxNum;
}
