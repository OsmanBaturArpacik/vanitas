import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBBtn,
    MDBInput, MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem,
} from 'mdb-react-ui-kit';
import React, {useEffect, useState} from 'react';
import ApiRequest from "./ApiRequest";
import 'react-toastify/dist/ReactToastify.css';
import { ToastInfo, ToastError } from './ToastComponents';

const Input = () => {
    const [protocol, setProtocol] = useState("https://");
    const [url, setUrl] = useState("");
    const { loading, apiTest} = ApiRequest();

    const handleSelect = (value) => {
        setProtocol(value);
    };

    useEffect(() => {
        setUrl(url.toLowerCase());
        if (url.startsWith('https://')) {
            setProtocol("https://")
        }
        if (url.startsWith('http://')) {
            setProtocol("http://")
        }
    }, [url]);

    const isUrlValid = (userInput) => {
        const regex = /^(?:(?:https?|ftp):\/\/)(?:\S+(?::\S*)?@)?(?:(?!10(?:\.\d{1,3}){3})(?!127(?:\.\d{1,3}){3})(?!169\.254(?:\.\d{1,3}){2})(?!192\.168(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]+-?)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]+-?)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/[^\s]*)?$/i;
        var res = userInput.match(regex);
        if (res == null) {
            return false;
        }
        else {
            return true;
        }
    }

    const handleButtonClick = () => {
        try {
            if (url == null) {
                throw new Error("Lütfen URL giriniz: www.example.org");
            }
            // else if (!(url.includes("https://") || url.includes("http://")) && !url.startsWith('www.')) {
            //     throw new Error("Lütfen formata uygun URL giriniz: www.example.org");
            // }
            else if (!(url.includes("https://") || url.includes("http://")) && !isUrlValid(protocol + url)) {
                throw new Error("Lütfen formata uygun URL giriniz: www.example.org, example.org https://example.org, https://www.example.org");
            }
            else if (!(url.includes("https://") || url.includes("http://") || !isUrlValid(protocol + url))) {
                apiTest(protocol + url);
                ToastInfo(protocol + url + " için işlem başladı.");
            }
            else {
                apiTest(url);
                ToastInfo(protocol + url + " için işlem başladı.");
            }
        } catch (error) {
            setUrl("");
            ToastError("Bir hata oluştu, \n" + error.message);
            console.log(error);
        }
    };


    return (
        <>
            <MDBContainer breakpoint="xxl" className="flex-grow-0 py-1">
                <MDBContainer fluid className='p-0'>
                    <MDBRow>
                        <MDBCol size='12'>
                            <MDBContainer fluid className='py-3'>
                                <MDBRow>
                                    <MDBCol md='1' className='d-flex justify-content-center py-1'>
                                        <MDBDropdown>
                                            <MDBDropdownToggle tag='a' className='btn btn-primary' style={{ width: '100px', textAlign: 'left', fontWeight:'bold'}}>
                                                {protocol}
                                            </MDBDropdownToggle>
                                            <MDBDropdownMenu>
                                                <MDBDropdownItem link onClick={() => handleSelect('https://')}>HTTPS://</MDBDropdownItem>
                                                <MDBDropdownItem link onClick={() => handleSelect('http://')}>HTTP://</MDBDropdownItem>
                                            </MDBDropdownMenu>
                                        </MDBDropdown>
                                    </MDBCol>
                                    <MDBCol md='8' className='d-flex justify-content-center py-1'>
                                        <MDBInput label="URL" id="typeURL" type="url" placeholder="example.org"
                                                  value={url}
                                                  onChange={(e) => setUrl(e.target.value)}
                                        />
                                    </MDBCol>
                                    <MDBCol md='3' className='d-flex justify-content-center py-1'>
                                        <MDBBtn onClick={handleButtonClick} disabled={loading} className='w-100'>
                                            {loading ? 'Yükleniyor...' : 'Gönder'}
                                        </MDBBtn>
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