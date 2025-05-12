package com.target.entity.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "List") // nome do nó raiz
public class VendaDTOWrapper {
	@JacksonXmlElementWrapper(useWrapping = false) // não embrulha em lista extra
    @JacksonXmlProperty(localName = "row") // define o nome do item
    private List<VendaDTO> vendas;

    // getters e setters
    public List<VendaDTO> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaDTO> vendas) {
        this.vendas = vendas;
    }
}
