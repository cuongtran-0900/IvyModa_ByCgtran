package ivymoda.domain;

import static ivymoda.domain.CategoryTestSamples.*;
import static ivymoda.domain.CategoryTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import ivymoda.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Category.class);
        Category category1 = getCategorySample1();
        Category category2 = new Category();
        assertThat(category1).isNotEqualTo(category2);

        category2.setId(category1.getId());
        assertThat(category1).isEqualTo(category2);

        category2 = getCategorySample2();
        assertThat(category1).isNotEqualTo(category2);
    }

    @Test
    void parentTest() {
        Category category = getCategoryRandomSampleGenerator();
        Category categoryBack = getCategoryRandomSampleGenerator();

        category.setParent(categoryBack);
        assertThat(category.getParent()).isEqualTo(categoryBack);

        category.parent(null);
        assertThat(category.getParent()).isNull();
    }

    @Test
    void childrenTest() {
        Category category = getCategoryRandomSampleGenerator();
        Category categoryBack = getCategoryRandomSampleGenerator();

        category.addChildren(categoryBack);
        assertThat(category.getChildren()).containsOnly(categoryBack);
        assertThat(categoryBack.getParent()).isEqualTo(category);

        category.removeChildren(categoryBack);
        assertThat(category.getChildren()).doesNotContain(categoryBack);
        assertThat(categoryBack.getParent()).isNull();

        category.children(new HashSet<>(Set.of(categoryBack)));
        assertThat(category.getChildren()).containsOnly(categoryBack);
        assertThat(categoryBack.getParent()).isEqualTo(category);

        category.setChildren(new HashSet<>());
        assertThat(category.getChildren()).doesNotContain(categoryBack);
        assertThat(categoryBack.getParent()).isNull();
    }
}
