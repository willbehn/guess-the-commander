import React, { useState } from 'react';
import axios from 'axios';

const Card = () => {
    const [cardImageUrl, setCardImageUrl] = useState(null);
    const [loading, setLoading] = useState(false);

    const fetchCardImage = () => {
        setLoading(true);
        axios.get('http://localhost:8080/api/card/daily')
            .then(response => {
                setCardImageUrl(response.data.normalImageUrl);
                setLoading(false);
            });
    };

    return (
        <div>
            <h1>Card Image</h1>
            <button onClick={fetchCardImage}>Get Card Image</button>
            {loading && <p>Loading...</p>}
            {cardImageUrl && !loading && (
                <img src={cardImageUrl} alt="Card" style={{ maxWidth: '100%', height: 'auto' }} />
            )}
        </div>
    );
};

export default Card;

