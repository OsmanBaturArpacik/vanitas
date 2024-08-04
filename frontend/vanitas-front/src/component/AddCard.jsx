import React, { useEffect, useState } from "react";
import {
    MDBCard,
    MDBCardBody,
    MDBCardText,
    MDBCardTitle,
    MDBContainer,
    MDBTable,
    MDBTableBody,
    MDBTableHead
} from "mdb-react-ui-kit";

const Card = ({ data, pageUrl }) => (
    <MDBCard className='m-1' style={{ maxWidth: '600px',minHeight: '400px'}}>
        <MDBCardBody>
            <MDBCardTitle>
                &nbsp;&nbsp;
                <a href={pageUrl} style={{ textDecoration: 'none' }}>{pageUrl}</a>
            </MDBCardTitle>
            <MDBCardText>
                <MDBContainer fluid style={{ maxHeight: '330px', minHeight: '250px', overflowY: 'auto' }}>
                    <MDBTable className='small table-striped table-light' fluid style={{ maxHeight: '200px'}}>
                            <MDBTableHead>
                                <tr>
                                    <th scope='col' style={{ position: 'sticky', top: '0', backgroundColor: '#106cfc', color: 'white', zIndex: '1' }}>#</th>
                                    <th scope='col' style={{ position: 'sticky', top: '0', backgroundColor: '#106cfc', color: 'white', zIndex: '1' }}>Hatalı Cümle</th>
                                    <th scope='col' style={{ position: 'sticky', top: '0', backgroundColor: '#106cfc', color: 'white', zIndex: '1' }}>Öneri Cümlesi</th>
                                </tr>
                            </MDBTableHead>
                            <MDBTableBody>
                                {data.map((row, rowIndex) => (
                                    <tr key={rowIndex}>
                                        <th scope='row'>{rowIndex + 1}</th>
                                        <td>{row.text}</td>
                                        <td>{row.suggestion}</td>
                                    </tr>
                                ))}
                            </MDBTableBody>
                        </MDBTable>
                </MDBContainer>
            </MDBCardText>
        </MDBCardBody>
    </MDBCard>
);

const AddCard = ({ dataList, urlList }) => {

    const [cards, setCards] = useState([]);

    useEffect(() => {
        if (dataList && dataList.length > 0) {
            const newCards = dataList.map((innerArray, index) => {
                // Assuming innerArray is an array from dataList, and index is used to access urlList
                const pageUrl = urlList[index % urlList.length]; // Using % operator to cycle through urlList items

                return (
                    <Card key={index} data={innerArray} pageUrl={pageUrl} />
                );
            });

            setCards(newCards);
        }
    }, [dataList, urlList]);

    return (
        <>
            {cards}
        </>
    );
};

export default AddCard;
