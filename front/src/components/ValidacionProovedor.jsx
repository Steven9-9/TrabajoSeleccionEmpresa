import * as Yup from 'yup'

export const ValidacionProovedor = Yup.object().shape({

    nitRut: Yup.string()
        .required('El NIT o RUT es obligatorio')
        .matches(/^[0-9]{8,10}$/, 'El NIT o RUT debe tener entre 8 y 10 dígitos.'),
    razonSocial: Yup.string()
        .required('Nombre de la empresa es obligatorio')
        .matches(/^[a-zA-Z]+$/, "Solo se permiten letras.")
        .max(100, 'El nombre o razón social no debe exceder los 100 caracteres.'),
    representante: Yup.string()
        .required('El nombre es obligatorio.')
        .matches(/^[a-zA-Z\s'-]+$/, 'El nombr solo puede contener letras.')
        .max(100, 'El nombre del representante legal no debe exceder los 100 caracteres.'),
    direccion: Yup.string()
        .required('La dirección es obligatoria.')
        .matches(/^[a-zA-Z0-9\s,'-]*$/, 'La dirección solo puede contener letras, números, comas, apóstrofes y guiones.'),
    telefono: Yup.string()
        .required('No puedes dejar este campo vacio')
        .matches(/^[0-9]{10}$/, 'El teléfono debe tener 10 dígitos.'),
    correo: Yup.string()
        .required('No puedes dejar este campo vacio')
        .matches(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/, "Correo electrónico no válido.")
        .email('El correo no es válido.'),
    ciudad: Yup.string()
        .required('No puedes dejar este campo vacio')
        .matches(/^[a-zA-Z]+$/, "Solo se permiten letras.")
        .max(50, 'La ciudad no debe exceder los 50 caracteres.'),
    pais: Yup.string()
        .required('No puedes dejar este campo vacio')
        .matches(/^[a-zA-Z]+$/, "Solo se permiten letras.")
        .max(50, 'El país no debe exceder los 50 caracteres.'),
    departamento: Yup.string()
        .required('No puedes dejar este campo vacio')
        .matches(/^[a-zA-Z]+$/, "Solo se permiten letras.")
        .max(50, 'El departamento no debe exceder los 50 caracteres.'),
    archivo: Yup.mixed()
        .required('Es obligatorio cargar un archivo.')
        .test('fileFormat', 'Solo se permite formato PDF.', (value) => {
            return value && value.type === 'application/pdf';
        })
});

