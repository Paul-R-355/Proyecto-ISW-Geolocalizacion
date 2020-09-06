/**
 * Mapa.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    longitud:{
      type: 'string'
    },
    latitud:{
      type: 'string'
    },
    paciente_fk:{
      type: 'string',
      unique: true,
      required: true
    },
    medico_fk:{
      type: 'string',
      unique: true,
      required: true
    },
    Administrador_fk:{
      type: 'string',
      unique: true,
      required: true
    }
  },

};

