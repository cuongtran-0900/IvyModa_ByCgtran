import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './role.reducer';

export const RoleDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const roleEntity = useAppSelector(state => state.role.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="roleDetailsHeading">
          <Translate contentKey="ivyModaApp.role.detail.title">Role</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{roleEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="ivyModaApp.role.name">Name</Translate>
            </span>
          </dt>
          <dd>{roleEntity.name}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="ivyModaApp.role.description">Description</Translate>
            </span>
          </dt>
          <dd>{roleEntity.description}</dd>
          <dt>
            <Translate contentKey="ivyModaApp.role.permissions">Permissions</Translate>
          </dt>
          <dd>
            {roleEntity.permissions
              ? roleEntity.permissions.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {roleEntity.permissions && i === roleEntity.permissions.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/role" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/role/${roleEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default RoleDetail;
