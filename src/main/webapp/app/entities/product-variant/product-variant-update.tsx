import React, { useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { Translate, ValidatedField, ValidatedForm, isNumber, translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntities as getProducts } from 'app/entities/product/product.reducer';
import { ProductSize } from 'app/shared/model/enumerations/product-size.model';
import { Color } from 'app/shared/model/enumerations/color.model';
import { createEntity, getEntity, reset, updateEntity } from './product-variant.reducer';

export const ProductVariantUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const products = useAppSelector(state => state.product.entities);
  const productVariantEntity = useAppSelector(state => state.productVariant.entity);
  const loading = useAppSelector(state => state.productVariant.loading);
  const updating = useAppSelector(state => state.productVariant.updating);
  const updateSuccess = useAppSelector(state => state.productVariant.updateSuccess);
  const productSizeValues = Object.keys(ProductSize);
  const colorValues = Object.keys(Color);

  const handleClose = () => {
    navigate(`/product-variant${location.search}`);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getProducts({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    if (values.id !== undefined && typeof values.id !== 'number') {
      values.id = Number(values.id);
    }
    if (values.price !== undefined && typeof values.price !== 'number') {
      values.price = Number(values.price);
    }
    if (values.stock !== undefined && typeof values.stock !== 'number') {
      values.stock = Number(values.stock);
    }

    const entity = {
      ...productVariantEntity,
      ...values,
      product: products.find(it => it.id.toString() === values.product?.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          productSize: 'S',
          color: 'RED',
          ...productVariantEntity,
          product: productVariantEntity?.product?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="ivyModaApp.productVariant.home.createOrEditLabel" data-cy="ProductVariantCreateUpdateHeading">
            <Translate contentKey="ivyModaApp.productVariant.home.createOrEditLabel">Create or edit a ProductVariant</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="product-variant-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('ivyModaApp.productVariant.productSize')}
                id="product-variant-productSize"
                name="productSize"
                data-cy="productSize"
                type="select"
              >
                {productSizeValues.map(productSize => (
                  <option value={productSize} key={productSize}>
                    {translate(`ivyModaApp.ProductSize.${productSize}`)}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField
                label={translate('ivyModaApp.productVariant.color')}
                id="product-variant-color"
                name="color"
                data-cy="color"
                type="select"
              >
                {colorValues.map(color => (
                  <option value={color} key={color}>
                    {translate(`ivyModaApp.Color.${color}`)}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField
                label={translate('ivyModaApp.productVariant.price')}
                id="product-variant-price"
                name="price"
                data-cy="price"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('ivyModaApp.productVariant.stock')}
                id="product-variant-stock"
                name="stock"
                data-cy="stock"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('ivyModaApp.productVariant.imageUrl')}
                id="product-variant-imageUrl"
                name="imageUrl"
                data-cy="imageUrl"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('ivyModaApp.productVariant.isActive')}
                id="product-variant-isActive"
                name="isActive"
                data-cy="isActive"
                check
                type="checkbox"
              />
              <ValidatedField
                id="product-variant-product"
                name="product"
                data-cy="product"
                label={translate('ivyModaApp.productVariant.product')}
                type="select"
              >
                <option value="" key="0" />
                {products
                  ? products.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/product-variant" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default ProductVariantUpdate;
