package website.bfmatching.Dto;

import lombok.Data;

@Data
public class AddFormDto {

    private String projectName;
    private String projectIntro;

    private String writerName;

    private String r_title1;
    private String r_title2;
    private String r_title3;

    private String r_content1;
    private String r_content2;
    private String r_content3;

//    private MultipartFile attachFile;
}
