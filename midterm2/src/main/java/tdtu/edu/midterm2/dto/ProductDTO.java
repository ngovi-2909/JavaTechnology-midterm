package tdtu.edu.midterm2.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String brand;
    private String color;
    private String imageName;
    private long categoryId;
}
