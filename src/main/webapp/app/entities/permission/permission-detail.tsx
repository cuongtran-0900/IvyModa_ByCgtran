import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './permission.reducer';

export const PermissionDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const permissionEntity = useAppSelector(state => state.permission.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="permissionDetailsHeading">
          <Translate contentKey="ivyModaApp.permission.detail.title">Permission</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{permissionEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="ivyModaApp.permission.name">Name</Translate>
            </span>
          </dt>
          <dd>{permissionEntity.name}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="ivyModaApp.permission.description">Description</Translate>
            </span>
          </dt>
          <dd>{permissionEntity.description}</dd>
          <dt>
            <Translate contentKey="ivyModaApp.permission.roles">Roles</Translate>
          </dt>
          <dd>
            {permissionEntity.roles
              ? permissionEntity.roles.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {permissionEntity.roles && i === permissionEntity.roles.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/permission" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/permission/${permissionEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default PermissionDetail;
