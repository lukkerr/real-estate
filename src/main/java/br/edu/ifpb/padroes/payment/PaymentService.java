package br.edu.ifpb.padroes.payment;

import br.edu.ifpb.padroes.domain.Property;
import br.edu.ifpb.padroes.payment.processors.GovernmentTaxesPayment;
import br.edu.ifpb.padroes.payment.processors.PropertyPayment;
import br.edu.ifpb.padroes.payment.processors.RealEstatePayment;

public class PaymentService {

    public void pay(Property sale) {
        GovernmentTaxesPayment governmentTaxesPayment = new GovernmentTaxesPayment();
        RealEstatePayment realEstatePayment = new RealEstatePayment();
        PropertyPayment propertyPayment = new PropertyPayment();

        governmentTaxesPayment.setNextProcessor(realEstatePayment);
        realEstatePayment.setNextProcessor(propertyPayment);
        governmentTaxesPayment.process(sale);;

    }

}
