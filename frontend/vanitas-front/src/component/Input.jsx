import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBBtn,
    MDBInput,
} from 'mdb-react-ui-kit';
import React, { useState } from 'react';
import ApiRequest from "./ApiRequest";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Input = () => {
    const [url, setUrl] = useState(""); // URL'yi saklamak için state ekleyin
    const { loading, apiTest} = ApiRequest();

    const notify = () => toast("Wow so easy!");
    const handleButtonClick = () => {
        try {
            if (url) {
                toast("Wow so easy!");
                apiTest(url);
            }
            else {
                //TODO: check url, toaster
                //TODO: initial hook problem
            }
        } catch (error) {
            console.log(error)
        }
    };


    return (
        <>
            <ToastContainer />
            <MDBContainer breakpoint="xxl" className="flex-grow-0 py-1">
                <MDBContainer fluid className='p-0'>
                    <MDBRow noGutters>
                        <MDBCol size='12'>
                            <MDBContainer fluid className='py-3'>
                                <MDBRow>
                                    <MDBCol md='9' className='d-flex justify-content-center py-1'>
                                        <MDBInput label="URL" id="typeURL" type="url"  placeholder="https://example.org"
                                                  value={url}
                                                  onChange={(e) => setUrl(e.target.value)}
                                        />
                                    </MDBCol>
                                    <MDBCol md='3' className='d-flex justify-content-center py-1'>
                                        <MDBBtn onClick={handleButtonClick} disabled={loading} className='w-100'> {loading ? 'Yükleniyor...' : 'Gönder'}</MDBBtn>
                                    </MDBCol>
                                </MDBRow>
                            </MDBContainer>
                        </MDBCol>
                    </MDBRow>
                </MDBContainer>
            </MDBContainer>
        </>
    )
}

export default Input;