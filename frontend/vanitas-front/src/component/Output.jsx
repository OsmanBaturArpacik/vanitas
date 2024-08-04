import React, {useEffect, useContext} from 'react';
import {
    MDBContainer,
    MDBRow,
} from 'mdb-react-ui-kit';
import AddCard from './AddCard';
import {DataContext} from "../App";

const Output = () => {
    const { data } = useContext(DataContext);
    const { newDataList, urlList } = data;

    useEffect(() => {
        console.log('New data list:', newDataList);
        console.log('New URL set:', urlList);
    }, [newDataList, urlList]);

    return (
        <>
            <MDBContainer breakpoint='xxl' className='flex-grow-1'>
                <MDBContainer fluid className='p-2'>
                    <MDBContainer fluid className='py-1' style={{ maxHeight: '500px', overflowY: 'auto' }}>
                        <MDBRow style={{ display: 'flex', flex: 'wrap', justifyContent: 'space-around'}}>
                            <AddCard dataList={newDataList} urlList={urlList}/>
                        </MDBRow>
                    </MDBContainer>
                </MDBContainer>
            </MDBContainer>
        </>
    );
};

export default Output;