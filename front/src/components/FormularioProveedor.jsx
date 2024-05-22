import React, { useState } from 'react';
import { useFormik } from 'formik';
import { ValidacionProovedor } from './ValidacionProovedor';
import Swal from 'sweetalert2';

const FormularioProveedor = () => {
    const [tipoProveedor, setTipoProveedor] = useState('');
    const [formularioEnviado, setFormularioEnviado] = useState(false);
    const [archivoUrl, setArchivoUrl] = useState('');


    const gestorFormulario = useFormik({
        initialValues: {
            nitRut: '',
            razonSocial: '',
            representante: '',
            direccion: '',
            telefono: '',
            correo: '',
            ciudad: '',
            pais: '',
            departamento: '',
           

        },

        validationSchema: ValidacionProovedor,
        onSubmit: async (values) => {
            try {

                const datosConArchivoUrl = { ...values, archivo: archivoUrl };

                const response = await fetch('http://localhost:8080/api/proveedores', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                   body: JSON.stringify(datosConArchivoUrl)
                });
                if (response.ok) {
                 Swal.fire("Se ha enviado la informacion")
                    setFormularioEnviado(true);
                } else {
                    
                    Swal.fire("Error al enviar el formulario")
                }
            } catch (error) {
               
                Swal.fire("Error en la solicitud", error)
            }
        }

    })



    const handleTipoChange = (e) => {
        setTipoProveedor(e.target.value);
    };

    const handleFileChange = (event) => {
        // Generar la URL del archivo y guardarla en el estado
        const file = event.target.files[0];
        const url = URL.createObjectURL(file);
        setArchivoUrl(url);

        // Llamar a la función handleChange de Formik para manejar el cambio del archivo
        gestorFormulario.handleChange(event);
    };


    return (
        <form onSubmit={gestorFormulario.handleSubmit}>
            <div>
                <label style={{
                    color: 'black'
                }}>Tipo de Proveedor:</label>
                <select value={tipoProveedor} onChange={handleTipoChange}>
                    <option value="">Seleccione...</option>
                    <option value="natural">Persona Natural</option>
                    <option value="juridica">Persona Jurídica</option>
                </select>
            </div>
            {/*<div className='fondo'></div>*/}
            <div className='natural'>

                {tipoProveedor === 'natural' && (
                    <div>
                        <h2 style={{
                            textAlign: 'center'
                        }}>Persona Natural</h2>
                        <div>
                            <label>Nombre:</label>
                            <input type="text"
                                name="representante"
                                value={gestorFormulario.values.representante}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.representante && gestorFormulario.errors.representante ? <p>{gestorFormulario.errors.representante}</p> : null}

                        </div>
                        <div>
                            <label>País:</label>
                            <input
                                type="text"
                                name="pais"
                                value={gestorFormulario.values.pais}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.pais && gestorFormulario.errors.pais ? <p>{gestorFormulario.errors.pais}</p> : null}
                        </div>
                        <div>
                            <label>Departamento:</label>
                            <input
                                type="text"
                                name="departamento"
                                value={gestorFormulario.values.departamento}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.departamento && gestorFormulario.errors.departamento ? <p>{gestorFormulario.errors.departamento}</p> : null}
                        </div>
                        <div>
    <label>Ciudad:</label>
    <input
        type="text"
        name="ciudad"
        value={gestorFormulario.values.ciudad}
        onChange={gestorFormulario.handleChange}
        onBlur={gestorFormulario.handleBlur}
    />
    {gestorFormulario.touched.ciudad && gestorFormulario.errors.ciudad ? <p>{gestorFormulario.errors.ciudad}</p> : null}
</div>
                        <div>
                            <label>Dirección:</label>
                            <input type="text"
                                name="direccion"
                                value={gestorFormulario.values.direccion}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.direccion && gestorFormulario.errors.direccion ? <p>{gestorFormulario.errors.direccion}</p> : null}

                        </div>
                        <div>
                            <label>Teléfono:</label>
                            <input type="text"
                                name="telefono"
                                value={gestorFormulario.values.telefono}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.telefono && gestorFormulario.errors.telefono ? <p>{gestorFormulario.errors.telefono}</p> : null}

                        </div>
                        <div>
                            <label>Correo:</label>
                            <input type="email"
                                name="correo"
                                value={gestorFormulario.values.correo}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.onBlur}

                            />
                            {gestorFormulario.touched.correo && gestorFormulario.errors.correo ? <p>{gestorFormulario.errors.correo}</p> : null}

                        </div>
                        <div>
                            <label>RUT:</label>
                            <input type="file"
                                name="rut"
                                accept='.pdf'
                                onChange={(event) => gestorFormulario.setFieldValue('archivo', event.currentTarget.files[0])}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.archivo && gestorFormulario.errors.archivo ? <p>{gestorFormulario.errors.archivo}</p> : null}

                        </div>
                    </div>
                )}
            </div>

            <div className='juridica'>
                {tipoProveedor === 'juridica' && (
                    <div>
                        <h2 style={{
                            textAlign: 'center'
                        }}>Persona Jurídica</h2>
                        <div>
                            <label>Empresa:</label>
                            <input type="text"
                                name="razonSocial"
                                value={gestorFormulario.values.razonSocial}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.onBlur}

                            />
                            {gestorFormulario.touched.razonSocial && gestorFormulario.errors.razonSocial ? <p>{gestorFormulario.errors.razonSocial}</p> : null}


                        </div>
                        <div>
                            <label>Representante:</label>
                            <input type="text"
                                name="representante"
                                value={gestorFormulario.values.representante}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.representante && gestorFormulario.errors.representante ? <p>{gestorFormulario.errors.representante}</p> : null}

                        </div>
                        <div>
                            <label>NIT:</label>
                            <input type="text"
                                name="nitRut"
                                value={gestorFormulario.values.nitRut}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.onBlur}
                            />
                            {gestorFormulario.touched.nitRut && gestorFormulario.errors.nitRut ? <p>{gestorFormulario.errors.nitRut}</p> : null}
                        </div>
                        <div>
                            <label>País:</label>
                            <input
                                type="text"
                                name="pais"
                                value={gestorFormulario.values.pais}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.pais && gestorFormulario.errors.pais ? <p>{gestorFormulario.errors.pais}</p> : null}
                        </div>
                        <div>
                            <label>Departamento:</label>
                            <input
                                type="text"
                                name="departamento"
                                value={gestorFormulario.values.departamento}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.departamento && gestorFormulario.errors.departamento ? <p>{gestorFormulario.errors.departamento}</p> : null}
                        </div>
                        <div>
    <label>Ciudad:</label>
    <input
        type="text"
        name="ciudad"
        value={gestorFormulario.values.ciudad}
        onChange={gestorFormulario.handleChange}
        onBlur={gestorFormulario.handleBlur}
    />
    {gestorFormulario.touched.ciudad && gestorFormulario.errors.ciudad ? <p>{gestorFormulario.errors.ciudad}</p> : null}
</div>
                        <div>
                            <label>Dirección:</label>
                            <input type="text"
                                name="direccion"
                                value={gestorFormulario.values.direccion}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.direccion && gestorFormulario.errors.direccion ? <p>{gestorFormulario.errors.direccion}</p> : null}

                        </div>
                        <div>
                            <label>Teléfono:</label>
                            <input type="text"
                                name="telefono"
                                value={gestorFormulario.values.telefono}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.telefono && gestorFormulario.errors.telefono ? <p>{gestorFormulario.errors.telefono}</p> : null}
                        </div>
                        <div>
                            <label>Correo:</label>
                            <input type="email"
                                name="correo"
                                value={gestorFormulario.values.correo}
                                onChange={gestorFormulario.handleChange}
                                onBlur={gestorFormulario.onBlur}

                            />
                            {gestorFormulario.touched.correo && gestorFormulario.errors.correo ? <p>{gestorFormulario.errors.correo}</p> : null}

                        </div>
                        <div>
                            <label>RUT:</label>
                            <input type="file"
                                name="rut"
                                accept='.pdf'
                                onChange={(event) => gestorFormulario.setFieldValue('archivo', event.currentTarget.files[0])}
                                onBlur={gestorFormulario.handleBlur}
                            />
                            {gestorFormulario.touched.archivo && gestorFormulario.errors.archivo ? <p>{gestorFormulario.errors.archivo}</p> : null}

                        </div>
                    </div>

                )}
            </div>


            {tipoProveedor && <button type="submit" className='enviar' >Enviar</button>}
            {formularioEnviado && Swal.fire("Se ha enviado la informacion")}

            
        </form>
    );
};

export default FormularioProveedor;
