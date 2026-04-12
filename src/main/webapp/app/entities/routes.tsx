import React from 'react';
import { Route } from 'react-router'; // eslint-disable-line

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Role from './role';
import Permission from './permission';
import UserAccount from './user-account';
import Cart from './cart';
import CartItem from './cart-item';
import Product from './product';
import ProductVariant from './product-variant';
import Category from './category';
import Notification from './notification';
import Order from './order';
import OrderItem from './order-item';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        <Route path="role/*" element={<Role />} />
        <Route path="permission/*" element={<Permission />} />
        <Route path="user-account/*" element={<UserAccount />} />
        <Route path="cart/*" element={<Cart />} />
        <Route path="cart-item/*" element={<CartItem />} />
        <Route path="product/*" element={<Product />} />
        <Route path="product-variant/*" element={<ProductVariant />} />
        <Route path="category/*" element={<Category />} />
        <Route path="notification/*" element={<Notification />} />
        <Route path="order/*" element={<Order />} />
        <Route path="order-item/*" element={<OrderItem />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
