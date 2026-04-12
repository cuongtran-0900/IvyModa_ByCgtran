import role from 'app/entities/role/role.reducer';
import permission from 'app/entities/permission/permission.reducer';
import userAccount from 'app/entities/user-account/user-account.reducer';
import cart from 'app/entities/cart/cart.reducer';
import cartItem from 'app/entities/cart-item/cart-item.reducer';
import product from 'app/entities/product/product.reducer';
import productVariant from 'app/entities/product-variant/product-variant.reducer';
import category from 'app/entities/category/category.reducer';
import notification from 'app/entities/notification/notification.reducer';
import order from 'app/entities/order/order.reducer';
import orderItem from 'app/entities/order-item/order-item.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  role,
  permission,
  userAccount,
  cart,
  cartItem,
  product,
  productVariant,
  category,
  notification,
  order,
  orderItem,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
