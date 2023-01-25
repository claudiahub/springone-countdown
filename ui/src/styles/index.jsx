import styled from 'styled-components';

const AppStyled = styled.div`
  background-image: linear-gradient(15deg, #1a1a1a, var(--color-bg));
  color: var(--color-text);
  display: flex;
  min-height: 100vh;
`;

const ContainerStyled = styled.section`
  margin: auto;
  padding: 1rem;

  @media (min-width: 48em) {
    padding: 4rem;
  }
`;

const WrapperStyled = styled.div`
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 1rem;

  @media (min-width: 35.5em) {
    grid-template-columns: repeat(4, minmax(0, 1fr));
    gap: 0 2rem;
  }
`;

const DateStyled = styled.header`
  margin-bottom: 2rem;

  & h1 {
    color: var(--color-heading);
    font-family: var(--font-family-heading);
    font-size: clamp(1rem, 2vw, 99rem);
    font-weight: 300;
    letter-spacing: 0.1875em;
    margin: unset;
    text-align: center;
    text-transform: uppercase;
  }
`;

const CounterStyled = styled.div`
  background: rgba(255, 255, 255, 0.025);
  border-radius: 1rem;
  color: var(--color-counter);
  display: flex;
  flex-direction: column;
  font-family: "JetBrains Mono", mono;
  font-size: clamp(1rem, 8vw, 99rem);
  font-weight: 100;
  line-height: 1;
  padding: 2vw
  text-align: center;

  h2 {
    color: var(--color-heading);
    font-family: var(--font-family-heading);
    font-size: clamp(1rem, 2vw, 99rem);
    font-weight: 300;
    letter-spacing: .1875em;
    margin: 1.25rem 0 0;
    order: 1;
    overflow: hidden
    text-overflow: ellipsis;
    text-transform: uppercase;
    white-space: nowrap;
    width: 100%;
  }
`;

const AnimateStyled = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  width: 120px;
  height: 120px;
  margin:-60px 0 0 -60px;
  -webkit-animation:spin 4s linear infinite;
  -moz-animation:spin 4s linear infinite;
  animation:spin 3s linear infinite;
}
@-moz-keyframes spin { 100% { -moz-transform: rotate(360deg); } }
@-webkit-keyframes spin { 100% { -webkit-transform: rotate(360deg); } }
@keyframes spin { 100% { -webkit-transform: rotate(360deg); transform:rotate(360deg); } }
`

const ImageStyled = styled.div`
  width: 24px;
  height: 24px;
`;

export { 
    AppStyled, 
    DateStyled,
    ImageStyled,
    AnimateStyled,
    WrapperStyled, 
    CounterStyled,
    ContainerStyled
}