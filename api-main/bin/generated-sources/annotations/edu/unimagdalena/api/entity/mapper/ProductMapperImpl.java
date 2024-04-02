package edu.unimagdalena.api.entity.mapper;

import edu.unimagdalena.api.entity.Product;
import edu.unimagdalena.api.entity.dto.ProductDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-02T01:48:59-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Float price = null;
        Integer stock = null;

        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        stock = product.getStock();

        ProductDTO productDTO = new ProductDTO( id, name, price, stock );

        return productDTO;
    }

    @Override
    public Product productDtoToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productDTO.id() );
        product.name( productDTO.name() );
        product.price( productDTO.price() );
        product.stock( productDTO.stock() );

        return product.build();
    }
}
