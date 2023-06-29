package br.com.rickferry.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddress {

    @Column(name = "`ZIP_CODE`")
    private String zipCode;
    
    @Column(name = "`PUBLIC_PLACE`")
    private String publicPlace;
    
    @Column(name = "`NUMBER`")
    private String number;

    @Column(name = "`COMPLEMENT`")
    private String complement;

    @Column(name = "`NEIGHBORHOOD`")
    private String neighborhood;

    @Column(name = "`CITY`")
    private String city;

    @Column(name = "`STATE`")
    private String state;
}
