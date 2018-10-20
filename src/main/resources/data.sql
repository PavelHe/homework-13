insert into acl_sid (id, principal, sid) values
  (1, 1, 'James'),
  (2, 1, 'Adam');

insert into acl_class (id, class) values
  (1, 'com.github.pavelhe.model.User');

insert into user(id,uuid,amount,description) values
  (1,'RANDOM_UUID_1', 1000, 'James desc'),
  (2,'RANDOM_UUID_2', 1000, 'Adam desc');

insert into acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) values
  (1, 1, 1, null, 1, 0),
  (2, 1, 2, null, 1, 0),
  (3, 1, 3, null, 1, 0);

insert into acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) values
  (1, 1, 1, 1, 1, 1, 1, 1),
  (2, 1, 2, 1, 2, 1, 1, 1),
  (3, 1, 3, 1, 4, 1, 1, 1);