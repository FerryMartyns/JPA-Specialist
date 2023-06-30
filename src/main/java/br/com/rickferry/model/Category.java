package br.com.rickferry.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     */
    @Column(name = "`NAME`")
    private String name;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "category_father_id")
    private Category categoryFather;

    /**
     *
     */
    @OneToMany(mappedBy = "categoryFather")
    private List<Category> categories;
}
