import {ColaboradorCompetenciaModel} from "./colaborador-competencia.model";

export class ColaboradorPostModel {

    nome: string;
    sborenome: string;
    cpf: string;
    email: string;
    data_nasc: Date;
    data_admi: Date;
    id_senioridade: number;
    competencias: ColaboradorCompetenciaModel[]

}

