import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/*
    -POJO class for product details.
 */
public class ProductDetails {

    public ProductDetails(String optionTitle, String description, BigDecimal price, String discount) {
        this.optionTitle = optionTitle;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    @JsonProperty("option title")
    String optionTitle;

    @JsonProperty("description")
    String description;

    @JsonProperty("price")
    BigDecimal price;

    @JsonProperty("discount")
    String discount;

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
