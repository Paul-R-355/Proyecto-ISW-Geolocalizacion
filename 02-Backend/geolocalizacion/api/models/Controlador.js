/**
 * Controlador.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{
      type: 'string',
      minLength: 3,
      required:true
    },
    cedula:{
      type: 'string',
      unique: true,
      required:true,
      minLength:10,
      maxLength:25
    },
    clave:{
      type:'string',
      regex: /^[a-zA-Z]\w{3,14}$/
    },
    correo:{
      type:'string',
      isEmail: true
    },
  },
};

