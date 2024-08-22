import React, { useState } from 'react';
import axios from 'axios';
import './Card.css'; 

const Card = () => {
    const [cardImageUrl, setCardImageUrl] = useState(null);
    const [loading, setLoading] = useState(false);

    const fetchCardImage = () => {
        setLoading(true);
        axios.get('http://localhost:8080/api/card/daily')
            .then(response => {
                setCardImageUrl(response.data.normalImageUrl);
                setLoading(false);
            })
            .catch(error => {
                console.error("Error fetching card image:", error);
                setLoading(false);
            });
    };

    React.useEffect(() => {
        fetchCardImage();
    }, []);

    return (
        <div>
            <h1>Card Image</h1>
            {loading && <p>Loading...</p>}
            {cardImageUrl && !loading && (
                <div className="card-container">
                    <img
                        src={cardImageUrl}
                        alt="Card"
                        className="card-image"
                        onClick={fetchCardImage} 
                    />
                </div>
            )}
        </div>
    );
};

export default Card;

