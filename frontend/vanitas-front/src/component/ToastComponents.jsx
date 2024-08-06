import React from 'react';
import { toast, ToastContainer } from 'react-toastify';
import { Flip } from 'react-toastify';

export const ToastSuccess = (message) => {
    toast.success(message, {
        transition: Flip,
    });
};

export const ToastInfo = (message) => {
    toast.info(message, {
        transition: Flip,
    });
};

export const ToastError = (message) => {
    toast.error(message, {
        transition: Flip,
    });
};

export const ToastProvider = () => (
    <>
        <ToastContainer
            position="top-right"
            autoClose={5000}
            limit={5}
            hideProgressBar={false}
            newestOnTop={false}
            closeOnClick
            rtl={false}
            pauseOnFocusLoss
            draggable
            pauseOnHover
            theme="colored"
        />
    </>
);