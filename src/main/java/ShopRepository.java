public class ShopRepository {
    private Product[] products = new Product[0];

    // Вспомогательный метод для добавления элемента в массив
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    // Метод добавления товара в репозиторий
    public void add(Product product) {
        products = addToArray(products, product);
    }

    // Получить все товары
    public Product[] findAll() {
        return products;
    }

    // Найти по id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Удалить по id с генерацией NotFoundException
    public void removeById(int id) {
        Product productToRemove = findById(id);
        if (productToRemove == null) {
            throw new NotFoundException(id);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}