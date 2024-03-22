INSERT INTO role (designation) VALUES ('CHEF'), ('OUVRIER'), ('ADMIN');

INSERT INTO utilisateur (pseudo, mot_de_passe, role_id, admin) VALUES
                                                                   ('chefUser', '$2y$10$dsJcM4S/PU32EYaa1pmVAuGDm6zJiHchgpCKSSHg3Vt1sUlnbsMeK', (SELECT id FROM role WHERE designation = 'CHEF'), 0),
                                                                   ('ouvrierUser', '$2y$10$dsJcM4S/PU32EYaa1pmVAuGDm6zJiHchgpCKSSHg3Vt1sUlnbsMeK', (SELECT id FROM role WHERE designation = 'OUVRIER'), 0),
                                                                   ('adminUser', '$2y$10$dsJcM4S/PU32EYaa1pmVAuGDm6zJiHchgpCKSSHg3Vt1sUlnbsMeK', (SELECT id FROM role WHERE designation = 'ADMIN'), 1);

INSERT INTO chantier (nom, adresse, chef_id, client_id) VALUES
                                                            ('Chantier A', '123 Rue Principale', (SELECT id FROM utilisateur WHERE pseudo = 'chefUser'), (SELECT id FROM utilisateur WHERE pseudo = 'adminUser')),
                                                            ('Chantier B', '456 Rue Secondaire', (SELECT id FROM utilisateur WHERE pseudo = 'chefUser'), (SELECT id FROM utilisateur WHERE pseudo = 'adminUser'));

INSERT INTO consommable (nom) VALUES ('Béton'), ('Briques');

INSERT INTO tache (nom, temps) VALUES ('Fondation', 120), ('Maçonnerie', 90);

INSERT INTO operation (chantier_id, date, tache_id, utilisateur_id, nom) VALUES
                                                                             ((SELECT id FROM chantier WHERE nom = 'Chantier A'), '2024-03-23', (SELECT id FROM tache WHERE nom = 'Fondation'), (SELECT id FROM utilisateur WHERE pseudo = 'ouvrierUser'), 'Préparation fondation'),
                                                                             ((SELECT id FROM chantier WHERE nom = 'Chantier A'), '2024-03-24', (SELECT id FROM tache WHERE nom = 'Maçonnerie'), (SELECT id FROM utilisateur WHERE pseudo = 'ouvrierUser'), 'Construction mur');

INSERT INTO tache_consommable (tache_id, consommable_id) VALUES
                                                             ((SELECT id FROM tache WHERE nom = 'Fondation'), (SELECT id FROM consommable WHERE nom = 'Béton')),
                                                             ((SELECT id FROM tache WHERE nom = 'Maçonnerie'), (SELECT id FROM consommable WHERE nom = 'Briques'));
