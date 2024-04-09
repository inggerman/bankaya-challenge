//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.04.09 a las 04:10:17 PM CST 
//


package com.bankaya.bankayasoap.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pokemon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pokemon"
})
@XmlRootElement(name = "locationAreaEncountersRequest")
public class LocationAreaEncountersRequest {

    @XmlElement(required = true)
    protected String pokemon;

    /**
     * Obtiene el valor de la propiedad pokemon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPokemon() {
        return pokemon;
    }

    /**
     * Define el valor de la propiedad pokemon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPokemon(String value) {
        this.pokemon = value;
    }

}
