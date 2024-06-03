package com.dr1.tp3.model.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "material_didatico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDidatico {
    @Id
    private String id;
    private String descricao;
}
